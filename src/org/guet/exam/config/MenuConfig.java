package org.guet.exam.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.InitBinder;

import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.bean.menu.WxMenu;
import me.chanjar.weixin.common.bean.menu.WxMenuButton;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;

/**
 * 自定义菜单结构
 * @author cx
 *
 */
public class MenuConfig {
	@Autowired
	private WxMpService wxMpService;
    /**
     * 定义菜单结构
     *
     * @return
     */
    public void getMenu( ) {
    	String contextPath="http://"+Configuration.getDomain();
    	
        WxMenu menu = new WxMenu();
        WxMenuButton button1 = new WxMenuButton();
        button1.setName("我是老师");
        
        WxMenuButton button11 = new WxMenuButton();
        button11.setType(WxConsts.BUTTON_VIEW);
        button11.setName("在线录题");
        button11.setUrl(contextPath+"/wx-exam/s/in/question/add");
        
        WxMenuButton button12 = new WxMenuButton();
        button12.setType(WxConsts.BUTTON_VIEW);
        button12.setName("自动组卷");
        button12.setUrl(contextPath+"/wx-exam/s/in/question/autopick");
        
        WxMenuButton button13 = new WxMenuButton();
        button13.setType(WxConsts.BUTTON_VIEW);
        button13.setName("题库检索");
        button13.setUrl(contextPath+"/wx-exam/s/in/question/search");
        
        WxMenuButton button15 = new WxMenuButton();
        button15.setType(WxConsts.BUTTON_VIEW);
        button15.setName("我的课程");
        button15.setUrl(contextPath+"/wx-exam/s/in/course/tlist");
        
        WxMenuButton button16 = new WxMenuButton();
        button16.setType(WxConsts.BUTTON_VIEW);
        button16.setName("发布课程");
        button16.setUrl(contextPath+"/wx-exam/s/in/course/add");
        
//        WxMenuButton button14 = new WxMenuButton();
//        button14.setType(WxConsts.BUTTON_VIEW);
//        button14.setName("身份认证");
//        button14.setUrl(contextPath+"/wx-exam/s/in/teacher/certified");

        WxMenuButton button2 = new WxMenuButton();
        button2.setName("我是学生");
        
        WxMenuButton button22 = new WxMenuButton();
        button22.setType(WxConsts.BUTTON_VIEW);
        button22.setName("我的课程");
        button22.setUrl(contextPath+"/wx-exam/s/in/course/slist");

        WxMenuButton button23 = new WxMenuButton();
        button23.setType(WxConsts.BUTTON_VIEW);
        button23.setName("选课");
        button23.setUrl(contextPath+"/wx-exam/s/in/course/select");

//        WxMenuButton button24 = new WxMenuButton();
//        button24.setType(WxConsts.BUTTON_VIEW);
//        button24.setName("身份认证");
//        button24.setUrl(contextPath+"/wx-exam/s/in/student/certified");

        button1.getSubButtons().add(button11);
        button1.getSubButtons().add(button12);
        button1.getSubButtons().add(button13);
//        button1.getSubButtons().add(button14);
        button1.getSubButtons().add(button15);
        button1.getSubButtons().add(button16);
        
        button2.getSubButtons().add(button22);
        button2.getSubButtons().add(button23);
//        button2.getSubButtons().add(button24);

        WxMenuButton button3 = new WxMenuButton();
        button3.setType(WxConsts.BUTTON_VIEW);
        button3.setName("身份认证");
        button3.setUrl(contextPath+"/wx-exam/s/user/certified");

        menu.getButtons().add(button1);
        menu.getButtons().add(button2);
        menu.getButtons().add(button3);
        
        try {
			wxMpService.getMenuService().menuCreate(menu);
		} catch (WxErrorException e) {
			e.printStackTrace();
		}
        
        System.out.println("=========="+"菜单加载完成"+"==========");
    }

    /**
     * 运行此main函数即可生成公众号自定义菜单
     *
     * @param args
     */
    /*public static void main(String[] args) {
        MainConfig mainConfig = new MainConfig();
        WxMpService wxMpService = mainConfig.wxMpService();
        try {
            wxMpService.getMenuService().menuCreate(getMenu());
        } catch (WxErrorException e) {
            e.printStackTrace();
        }
    }*/

}
