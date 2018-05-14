function flush(){
	if(window.confirm("是否确定将修改的内容刷新到应用？（若没有修改内容或修改内容较少建议不要频繁刷新，以免增加服务器负担！）")){
		  $.ajax({
		   url:'flush'
		   ,type:'POST'
		   ,data:$(document.form1).serialize()
		   ,success:function(data){
		       if(data==null||data=='')
			       alert("刷新成功");
		       else
		    	   alert('刷新失败');
		       
		   }
		   ,error:function(){alert('发生错误');}
		});
	}
   }
		function recommend(clazz,id){
			
		  $.ajax({
		   url:clazz+'/recommend?id='+id
		   ,type:'POST'
		   ,data:$(document.form1).serialize()
		   ,success:function(data){
		       if(data=='ok'){
		    	   if($("#recom_"+id).text()=='推荐'){
				       $("#recom_"+id).attr("class","btn btn-warning btn-xs");
				       $("#recom_"+id).text("取消推荐");
		    	   }else{
		    		   $("#recom_"+id).attr("class","btn btn-success btn-xs");
				       $("#recom_"+id).text("推荐");
		    	   }
		       }
		       else
		    	   alert('操作失败');
		       
		   }
		   ,error:function(){alert('发生错误');}
		});
   }
		function hot(clazz,id){
			
			$.ajax({
				url:clazz+'/hot?id='+id
				,type:'POST'
					,data:$(document.form1).serialize()
					,success:function(data){
						if(data=='ok'){
							if($("#hot_"+id).text()=='热门'){
								$("#hot_"+id).attr("class","btn btn-warning btn-xs");
								$("#hot_"+id).text("取消热门");
							}else{
								$("#hot_"+id).attr("class","btn btn-success btn-xs");
								$("#hot_"+id).text("热门");
							}
						}
						else
							alert('操作失败');
						
					}
			,error:function(){alert('发生错误');}
			});
		}
		function del(clazz,id){
			if(window.confirm("是否确定删除？")){
				
			  $.ajax({
			   url:clazz+'/delete?id='+id
			   ,type:'POST'
			   ,data:$(document.form1).serialize()
			   ,success:function(data){
			       if(data=='ok'){
			    	   $("#line_"+id).remove();
			       }
			       else
			    	   alert('删除失败');
			       
			   }
			   ,error:function(){alert('发生错误');}
			});
			}
   }
		function showCover(clazz,id){
				
				$.ajax({
					url:clazz+'/showCover?id='+id
					,type:'POST'
						,data:$(document.form1).serialize()
						,success:function(data){
							if(data=='ok'){
								$("#line_"+id).remove();
							}
							else
								alert('操作失败');
							
						}
				,error:function(){alert('发生错误');}
				});
		}