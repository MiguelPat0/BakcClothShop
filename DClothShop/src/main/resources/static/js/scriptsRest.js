/*!
* Start Bootstrap - Simple Sidebar v6.0.3 (https://startbootstrap.com/template/simple-sidebar)
* Copyright 2013-2021 Start Bootstrap
* Licensed under MIT (https://github.com/StartBootstrap/startbootstrap-simple-sidebar/blob/master/LICENSE)
*/
// 
// Scripts
// 
//var contextPath = "[[@{/}]]";
	var csrfHeader = "[[${_csrf.headerName}]]";
	var csrfToken = "[[${_csrf.token}]]";
	var listaTerreno;
	var nameImg;
	var srcImg;
	
	$(document).ready(function(){
		//$("#nCobro").prop('hidden', true);
		//$("#nc").prop('hidden', true);
		//cargaListaTerr()
		//$('#theDiv').prepend($('<img id="imgmodal">',{id:nameImg,src:srcImg}))
		$("#theDiv").append("<img id='theImg' src='/assets/jgm1.jpg'/>");
		listaTerreno=null
		//listarP()
		//var usuario={id:0,nombre:"Migu",correo:"",password: "123456"	
		//}
		// $('#modalNUsuario').modal('show');
		$("#loginn").on("click", function(e) {
        	
         	$('#modalNUsuario').modal('show'); // abrir  	
        });
        
        $("#btnCargar").on("click", function(e) {
        	
         	$('#modalNProd').modal('show'); // abrir  	
        });
        
        $("#closeMoNUA").on("click", function(e) {
        	
         	$('#modalNUsuario').modal('hide'); // cerrar  	
        });
        
        $("#guardaNUserA").on("click", function(e) {
        	
         	loguear();
        });
		
		function loguear(){
			var user = $('#iNombreA').val()
			var pass = $('#iContraseñaA').val()
        	url =  "http://localhost:8080/login/usuario";
          	jsonData = {nombre: user,
          	password:pass                
          	};
        	$.ajax({
        		type: "POST",
        		url: url,
        		//beforeSend: function(xhr){
        		//	xhr.setRequestHeader(csrfHeader, csrfToken);
        		//},
        		data: JSON.stringify(jsonData),
        		contentType: 'application/json'
        	}).done(function(user){
				 
        		if(user.id==0){
					alert(user.nombre);										
				}else{
					alert("Bienvenido "+user.nombre);
					$('#modalNUsuario').modal('hide');
					
					$('#iNombreA').val("")
					console.log(user);
				}      		
        		$('#iContraseñaA').val("")
				      		
        	}).fail(function(e){
        		alert("failed" + e 	);
        	});
        }
        
        function listarP(){
				
		    	url =  "http://localhost:8080/api/product/listPr";
		      	jsonData = {               
		      	};
		    	$.ajax({
		    		type: "post",
		    		url: url,
		    		//beforeSend: function(xhr){
		    		//	xhr.setRequestHeader(csrfHeader, csrfToken);
		    		//},
		    		data: JSON.stringify(jsonData),
		    		contentType: 'application/json'
		    	}).done(function(listProductos){
					 
		    		console.log(listProductos);
					 //$("#canva").empty();
					 $("#gal").append('<main class="gallery" id="canva">');
					 $.each(listProductos, function(index,produ){
						alert(produ.nombre)
						$("#canva").append('<div class="gallery__item">	<img th:src="@{/assets/jgm1.jpg}" alt="Jogger Mujer"></div>');
		        		alert(produ.id)
		        		}); 
		        	 $("#gal").append('</main>');		
		    	}).fail(function(e){
		    		alert("failed" + e 	);
		    	});
		    }
		    
		    $(document).on('click', '.modalconfirm', function (e) {
			//alert("clicl")
					var idpr=$(this).data("id");
	              	var nampr=$(this).data("name");
	              	var laur=$(this).data("url");
	              	srcImg=laur;
	              	$("#tittleMod").text(nampr);
	              	$(theImg).attr('src', srcImg);
					$('#myModalImg').modal('show');
					//$('<img>').attr('src',laur); 
	              	
	              	
	              	//$("#btnelipackage").attr("data-id",idpackage)
	            });
        
        
	});