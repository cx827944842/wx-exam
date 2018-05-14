package org.guet.exam.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import me.chanjar.weixin.common.bean.menu.WxMenuButton;

/**
 * 按钮
 * @author cx
 *
 */
@Entity
public class Button implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1696907735386097407L;
	private Long id;
	private String ekey;
	private String name;
	private String url;
	private String type;
	private String mediaId;
	private Set<Button> subButtons=new HashSet<>();
	private Button parentButton;
	
	@Id
	@GenericGenerator(name = "idGenerator", strategy = "native")
	@GeneratedValue(generator = "idGenerator")
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="parentId")
	public Button getParentButton() {
		return parentButton;
	}
	public void setParentButton(Button parentButton) {
		this.parentButton = parentButton;
	}
	
	@OneToMany(mappedBy="parentButton")
	@LazyCollection(LazyCollectionOption.EXTRA)
	public Set<Button> getSubButtons() {
		return subButtons;
	}
	public void setSubButtons(Set<Button> subButtons) {
		this.subButtons = subButtons;
	}
	
	
	public String getEkey() {
		return ekey;
	}
	public void setEkey(String ekey) {
		this.ekey = ekey;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getMediaId() {
		return mediaId;
	}
	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public WxMenuButton transToWx() {
		WxMenuButton button=new WxMenuButton();
		button.setKey(ekey);
		button.setMediaId(mediaId);
		button.setName(name);
		button.setType(type);
		button.setUrl(url);
		
		List<WxMenuButton> buttons=new ArrayList<WxMenuButton>();
		
		if(!subButtons.isEmpty())
			for(Button children:subButtons){
				buttons.add(children.transToWx());
			}
		
		button.setSubButtons(buttons);
			
		return button;
	}
	
	
}
