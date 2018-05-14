package org.guet.exam.controller.command;

/**
 * 添加非图文素材表单模型
 * 
 * @author cx
 *
 */
public class FileUploadCommand {
	private String mediaType;
	private String videoIntroduction;
	private String videoTitle;
	private boolean material;
	public String getMediaType() {
		return mediaType;
	}
	public void setMediaType(String mediaType) {
		this.mediaType = mediaType;
	}
	public String getVideoIntroduction() {
		return videoIntroduction;
	}
	public void setVideoIntroduction(String videoIntroduction) {
		this.videoIntroduction = videoIntroduction;
	}
	public String getVideoTitle() {
		return videoTitle;
	}
	public void setVideoTitle(String videoTitle) {
		this.videoTitle = videoTitle;
	}
	public boolean isMaterial() {
		return material;
	}
	public void setMaterial(boolean material) {
		this.material = material;
	}
	
	
}
