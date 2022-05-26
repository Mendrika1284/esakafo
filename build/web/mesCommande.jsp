<%@page import="model.DetailCommande"%>
<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!-->
<html class="no-js">
<!--<![endif]-->

  <%@ include file="content/head.jsp" %>
<body class="style-14">
 <%@ include file="content/header.jsp" %>
<!-- end header -->
<% DetailCommande[] listeDetailCommande = (DetailCommande[]) request.getAttribute("listeDetailCommande");%>
<!-- start main content -->
<main class="main-container">
	


<section id="popular-product" class="ecommerce">
	<div class="container">
		<!-- Shopping items content -->
		<div class="shopping-content">

			<!-- Block heading two -->
			<div class="block-heading-two">
				<h3><span>Mes Commandes</span></h3>
			</div>

			<% for(int i = 0; i < listeDetailCommande.length; i++){ %>
				<div class="col-md-3 col-sm-6">
					<div class="shopping-item">
						<!-- Image -->
                                                <a href="single-product.html"><img class="img-responsive"  src="img/plat/<%= listeDetailCommande[i].getNomPlat() %>.jpg" height="200" alt="" /></a>
						<!-- Shopping item name / Heading -->
						<h4><a href="single-product.html"><%= listeDetailCommande[i].getNomPlat()%></a><span class="color pull-right"><%= listeDetailCommande[i].getPrix()%>AR</span></h4>
						<div class="clearfix"></div>
                                                <form action="UpdateQuantite" method="get">
                                                    <input type="hidden" name="id" value="<%=listeDetailCommande[i].getId()%>">
                                                    <input type="hidden" name="idCommande" value="<%=listeDetailCommande[i].getIdCommande()%>">
             


                                                    <input type="number" class="form-control" value="<%=listeDetailCommande[i].getQuantite()%>" min="1" name ="quantite">
                                                    <br>
                                                     <button type="submit" class="btn btn-danger">Modifier</button>
                                                    
                                                </form>
                                                   
                                                <br>
                                                 <a href = "DeleteCommande?id=<%=listeDetailCommande[i].getId()%>&&idCommande=<%=listeDetailCommande[i].getIdCommande()%>" style="color:yellowgreen">Annuler</a>
                                                 <br><br>
                                                  <a href="VoirIngredient?idPlat=<%= listeDetailCommande[i].getIdPlat() %>" style="color:purple">Voir Ingredient</a>
                                        </div>
				</div>
                                                  <%  }%>
                                <br>
                                <form action="ControllerPanier" method="post">
                                  <% for(int i = 0; i < listeDetailCommande.length; i++){ %>   
                                  <input type="hidden" name="idCommande" value="<%=listeDetailCommande[i].getIdCommande()%>">
                                  <%  }%>
                                   <button type="submit" class="btn btn-primary" style="margin-top:550px;margin-bottom:30px">VALIDER COMMANDE</button>
                                  
                                <br>  
                                </form>
				
			</div>
			<!-- Pagination -->
			
			<div class="col-md-3 col-sm-6">
					<!-- Shopping items -->
					
				</div>
			<!-- Pagination end-->
		</div>
	</div>
</section>


	<!-- End Our Clients  -->

</main>
<%@ include file="content/footer.jsp" %>


<!-- All script -->
<script src="js/vendor/jquery-1.10.2.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/smoothscroll.js"></script>
<!-- Scroll up js
============================================ -->
<script src="js/jquery.scrollUp.js"></script>
<script src="js/menu.js"></script>
<!-- new collection section script -->
<script src="js/swiper/idangerous.swiper.min.js"></script>
<script src="js/swiper/swiper.custom.js"></script>

<!-- Magnific Popup -->
<script src="js/jquery.magnific-popup.min.js"></script>

<script src="js/jquery.countdown.min.js"></script>

<!-- SLIDER REVOLUTION SCRIPTS  -->
<script type="text/javascript" src="rs-plugin/js/jquery.themepunch.plugins.min.js"></script>
<script type="text/javascript" src="rs-plugin/js/jquery.themepunch.revolution.min.js"></script>
<!-- Owl carousel -->
<script src="js/owl.carousel.min.js"></script>
<script src="js/main.js"></script>



<script type="text/javascript">

	/*-----------------------------------------------------------------------------------*/
	/* Product Carousel
	 /*-----------------------------------------------------------------------------------*/
	if (jQuery().owlCarousel) {
		var productCarousel = $("#product-carousel");
		productCarousel.owlCarousel({
			loop: true,
			dots: false,
			responsive: {
				0: {
					items: 1
				},
				480: {
					items: 2
				},
				900: {
					items: 3
				},
				1100: {
					items: 4
				}
			}
		});

		// Custom Navigation Events
		$(".product-control-nav .next").on("click", function() {
			productCarousel.trigger('next.owl.carousel');
		});

		$(".product-control-nav .prev").on("click", function() {
			productCarousel.trigger('prev.owl.carousel');
		});
	}

	/* Main Slider */
	$('.tp-banner0').show().revolution({
		dottedOverlay: "none",
		delay: 5000,
		startWithSlide: 0,
		startwidth: 869,
		startheight: 520,
		hideThumbs: 10,
		hideTimerBar: "on",
		thumbWidth: 50,
		thumbHeight: 50,
		thumbAmount: 4,
		navigationType: "bullet",
		navigationArrows: "solo",
		navigationStyle: "round",
		touchenabled: "on",
		onHoverStop: "on",
		swipe_velocity: 0.7,
		swipe_min_touches: 1,
		swipe_max_touches: 1,
		drag_block_vertical: false,
		parallax: "mouse",
		parallaxBgFreeze: "on",
		parallaxLevels: [7, 4, 3, 2, 5, 4, 3, 2, 1, 0],
		keyboardNavigation: "off",
		navigationHAlign: "right",
		navigationVAlign: "bottom",
		navigationHOffset: 30,
		navigationVOffset: 30,
		soloArrowLeftHalign: "left",
		soloArrowLeftValign: "center",
		soloArrowLeftHOffset: 50,
		soloArrowLeftVOffset: 8,
		soloArrowRightHalign: "right",
		soloArrowRightValign: "center",
		soloArrowRightHOffset: 50,
		soloArrowRightVOffset: 8,
		shadow: 0,
		fullWidth: "on",
		fullScreen: "off",
		spinner: "spinner4",
		stopLoop: "on",
		stopAfterLoops: -1,
		stopAtSlide: -1,
		shuffle: "off",
		autoHeight: "off",
		forceFullWidth: "off",
		hideThumbsOnMobile: "off",
		hideNavDelayOnMobile: 1500,
		hideBulletsOnMobile: "off",
		hideArrowsOnMobile: "off",
		hideThumbsUnderResolution: 0,
		hideSliderAtLimit: 0,
		hideCaptionAtLimit: 500,
		hideAllCaptionAtLilmit: 500,
		videoJsPath: "rs-plugin/videojs/",
		fullScreenOffsetContainer: ""
	});



</script>


</body>


</html>