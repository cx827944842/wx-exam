package org.guet.exam.wx.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.guet.exam.bean.Article;
import org.guet.exam.config.Configuration;
import org.guet.exam.controller.command.ArticleCommand;
import org.guet.exam.controller.validator.ArticleValidator;
import org.guet.exam.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.bean.result.WxMediaUploadResult;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpMaterialService;
import me.chanjar.weixin.mp.api.WxMpService;

/**
 * 素材控制器
 * 
 * @author cx
 *
 */
@Controller
public class ArticleController {
	@Autowired
	private WxMpService service;
	@Autowired
	private ArticleService articleService;
	private ArticleValidator articleValidator = new ArticleValidator();

	/**
	 * article素材列表
	 * 
	 * @param model
	 * @return
	 * @throws WxErrorException
	 */
	@RequestMapping(value = "article/list")
	public String list(Model model) throws WxErrorException {

		model.addAttribute("articleList", articleService.findAll());
		return "article/list";
	}

	/**
	 * 显示文章编辑页面
	 * 
	 * @param command
	 * @param errors
	 * @return
	 * @throws WxErrorException
	 */
	@RequestMapping(value = "article/add", method = RequestMethod.GET)
	public String showForm(@ModelAttribute("article") ArticleCommand article, BindingResult errors)
			throws WxErrorException {
		return "article/saveUI";
	}

	@RequestMapping(value = "article/muldelte")
	public String delete(Long []articleIds) {
		articleService.delete(articleIds);
		return "redirect:list";
	}

	/**
	 * 添加文章
	 * 
	 * @param command
	 * @param errors
	 * @return
	 * @throws WxErrorException
	 */
	@RequestMapping(value = "article/add", method = RequestMethod.POST)
	public String add(HttpServletRequest request, @RequestParam(value = "file", required = false) MultipartFile file,
			@ModelAttribute("article") ArticleCommand article, BindingResult errors) throws WxErrorException {
		articleValidator.validate(article, errors);
		if (errors.hasErrors()) {
			return showForm(article, errors);
		}
		WxMpMaterialService materialService = service.getMaterialService();

		String mediaId = null;

		if (article.getThumbMediaId() == null || "".equals(article.getThumbMediaId())) {

			String path = request.getSession().getServletContext().getRealPath("image");
			String fileName = file.getOriginalFilename();
			File targetFile = new File(path, fileName);
			if (!targetFile.exists()) {
				targetFile.mkdirs();
			}
			// 保存
			try {
				file.transferTo(targetFile);

				WxMediaUploadResult result = materialService.mediaUpload(WxConsts.MEDIA_THUMB,WxConsts.FILE_JPG, new FileInputStream(targetFile));
				mediaId = result.getThumbMediaId();
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else {
			mediaId = article.getThumbMediaId();
		}
		Article a = new Article();
		a.setAuthor(article.getAuthor());
		a.setContent(article.getContent());
		a.setThumbMediaId(mediaId);
		a.setDigest(article.getDigest());
		a.setContentSourceUrl(article.getThumbUrl());
		a.setTitle(article.getTitle());
		a.setShowCoverPic(article.isShowCoverPic());
		a.setTime(new Date());
		
		articleService.save(a);

		return "redirect:list";
	}
	
	
	@RequestMapping(value="ckeditor/uploadFile")
	public void uploadFile(@RequestParam("upload") MultipartFile file,HttpServletRequest request,HttpServletResponse response){
		response.setContentType("text/html;charset=UTF-8");
//		response.setHeader("X-Frame-Options", "SAMEORIGIN");
		String CKEditorFuncNum = request.getParameter("CKEditorFuncNum");
		
		String path = Configuration.getImagePath();
		String fileName = System.currentTimeMillis()+"";
		File targetFile = new File(path, fileName);
		if (!targetFile.exists()) {
			targetFile.mkdirs();
		}
		// 保存
		try {
			if(targetFile.exists())
				targetFile.delete();
			
			file.transferTo(targetFile);
//			WxMpMaterialService materialService=service.getMaterialService();
//			WxMediaImgUploadResult result = materialService.mediaImgUpload(targetFile);
			String url = request.getServletContext().getContextPath()+"/image/"+targetFile.getName();
			PrintWriter out=response.getWriter();;
			String s = "<script type=\"text/javascript\">window.parent.CKEDITOR.tools.callFunction("+CKEditorFuncNum+", '"+url+"');</script>";
			out.print(s);
			out.flush();
			
//			Image image=new Image();
//			image.setLocalPath(targetFile.getAbsolutePath());
//			image.setUrl(url);
//			image.setWxUrl(result.getUrl());
//			imageService.save(image);
			
//			System.out.println("url:"+image.getUrl());
//			System.out.println("wxurl:"+image.getWxUrl());
//			System.out.println("path:"+image.getLocalPath());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
