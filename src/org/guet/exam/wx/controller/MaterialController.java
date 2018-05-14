package org.guet.exam.wx.controller;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.guet.exam.bean.Article;
import org.guet.exam.controller.command.FileUploadCommand;
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
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpMaterialService;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.WxMpMassNews;
import me.chanjar.weixin.mp.bean.WxMpMassNews.WxMpMassNewsArticle;
import me.chanjar.weixin.mp.bean.WxMpMassOpenIdsMessage;
import me.chanjar.weixin.mp.bean.material.WxMpMaterial;
import me.chanjar.weixin.mp.bean.material.WxMpMaterialFileBatchGetResult;
import me.chanjar.weixin.mp.bean.material.WxMpMaterialNews;
import me.chanjar.weixin.mp.bean.material.WxMpMaterialNews.WxMpMaterialNewsArticle;
import me.chanjar.weixin.mp.bean.material.WxMpMaterialNewsBatchGetResult;
import me.chanjar.weixin.mp.bean.result.WxMpMassUploadResult;
import me.chanjar.weixin.mp.bean.result.WxMpUserList;

/**
 * 素材控制器
 * 
 * @author cx
 *
 */
@Controller
public class MaterialController {
	@Autowired
	private WxMpService service;
	@Autowired
	private ArticleService articleService;


	/**
	 * 分页获取图文素材列表
	 * 
	 * @param request
	 * @param page
	 *            页码
	 * @return
	 * @throws WxErrorException
	 */
	@RequestMapping(value = "news/list")
	public String newslist(Model model) throws WxErrorException {
		WxMpMaterialService materialService = service.getMaterialService();

		// ==========图文素材=================
		int count = materialService.materialCount().getNewsCount();

		WxMpMaterialNewsBatchGetResult batchGetResult = materialService.materialNewsBatchGet(0,
				count == 0 ? 10 : count);

		model.addAttribute("newsList", batchGetResult.getItems());
		
		return "material/newslist";
	}
	@RequestMapping(value = "image/list")
	public String imagelist(Model model) throws WxErrorException {
		WxMpMaterialService materialService = service.getMaterialService();
		
		
		// ===========图片素材================
		int count = materialService.materialCount().getImageCount();
		
		WxMpMaterialFileBatchGetResult batchGetResult = materialService
				.materialFileBatchGet(WxConsts.MATERIAL_IMAGE, 0, count == 0 ? 10 : count);
		
		model.addAttribute("list", batchGetResult.getItems());
		return "material/filelist";
	}
	@RequestMapping(value = "video/list")
	public String videolist(Model model) throws WxErrorException {
		WxMpMaterialService materialService = service.getMaterialService();
		
		
		// ===========视频素材================
		int count = materialService.materialCount().getVideoCount();
		
		WxMpMaterialFileBatchGetResult batchGetResult = materialService
				.materialFileBatchGet(WxConsts.MATERIAL_VIDEO, 0, count == 0 ? 10 : count);
		
		model.addAttribute("list", batchGetResult.getItems());
		return "material/filelist";
	}
	@RequestMapping(value = "voice/list")
	public String voicelist(Model model) throws WxErrorException {
		WxMpMaterialService materialService = service.getMaterialService();
		
		// ===========音频素材================
		int count = materialService.materialCount().getVoiceCount();
		
		WxMpMaterialFileBatchGetResult batchGetResult = materialService
				.materialFileBatchGet(WxConsts.MATERIAL_VOICE, 0, count == 0 ? 10 : count);
		
		model.addAttribute("list", batchGetResult.getItems());
		return "material/filelist";
	}
	

	/**
	 * 非图文素材上传
	 * 
	 * @param request
	 * @param file
	 * @param mediaType
	 * @return
	 * @throws WxErrorException
	 * @throws IllegalStateException
	 * @throws IOException
	 */
	@RequestMapping(value = "file/upload" ,method=RequestMethod.GET)
	public String fileUploadForm(@ModelAttribute("command") FileUploadCommand command,BindingResult errors) {
		return "material/saveUI";
	}
	@RequestMapping(value = "file/upload" ,method=RequestMethod.POST)
	public String fileUpload(HttpServletRequest request,
			@RequestParam(value = "file", required = false) MultipartFile file,@ModelAttribute("command") FileUploadCommand command,
			BindingResult errors) throws WxErrorException, IllegalStateException, IOException {
		// TODO 验证

		WxMpMaterialService materialService = service.getMaterialService();
		String path = request.getSession().getServletContext().getRealPath("image");
		String fileName = file.getOriginalFilename()+System.currentTimeMillis();

		File targetFile = new File(path, fileName);

		if (!targetFile.exists()) {
			targetFile.mkdirs();
		}
		// 保存
		file.transferTo(targetFile);

		// 是否作为永久素材上传
		if (command.isMaterial()) {
			WxMpMaterial m = new WxMpMaterial();
			m.setFile(targetFile);
			m.setName(targetFile.getName());
			m.setVideoIntroduction(command.getVideoIntroduction());
			m.setVideoTitle(command.getVideoTitle());
			materialService.materialFileUpload(command.getMediaType(), m);
		} else {
			materialService.mediaUpload(command.getMediaType(), targetFile);
		}

		return "redirect:news/list";
	}
	

	/**
	 * 永久图文素材上传
	 * 
	 * @param command
	 * @param errors
	 * @return
	 * @throws WxErrorException
	 */
	@RequestMapping(value = "news/add")
	public String newsUpload(Long[] articleIds) throws WxErrorException {

		WxMpMaterialService materialService = service.getMaterialService();

		WxMpMaterialNews news = new WxMpMaterialNews();

		List<Article> articles = articleService.findByIds(articleIds);

		for (Article article : articles) {
			WxMpMaterialNewsArticle e = articleService.transToNews(article);

			news.getArticles().add(e);
		}

		materialService.materialNewsUpload(news);

		return "redirect:list";
	}

	/**
	 * 发送选中的图文消息
	 * 
	 * @param articleIds
	 *            文章id数组
	 * @return
	 * @throws WxErrorException
	 */
	@RequestMapping(value = "news/send")
	public String newsSend(Long articleIds[]) throws WxErrorException {
		WxMpMassNews news = new WxMpMassNews();
		List<Article> articles = articleService.findByIds(articleIds);

		for (Article article : articles) {
			WxMpMassNewsArticle a = articleService.transToMass(article);
			news.addArticle(a);
		}
		WxMpMassUploadResult result = service.massNewsUpload(news);
		WxMpMassOpenIdsMessage message = new WxMpMassOpenIdsMessage();

		WxMpUserList userList = service.getUserService().userList(null);
		List<String> openIds = userList.getOpenIds();
		for (String openId : openIds)
			message.addUser(openId);

		message.setMsgType(WxConsts.MASS_MSG_NEWS);
		message.setMediaId(result.getMediaId());
		service.massOpenIdsMessageSend(message);

		return "redirect:/s/article/list";
	}
	
	
}
