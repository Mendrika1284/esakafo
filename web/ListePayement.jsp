<%@page import="model.Facture"%>
<%
    int test = 0;
    Facture[] factureCheck = null;
    Facture[] factureEspece = null;
    if(request.getAttribute("check")!=null && request.getAttribute("espece")!=null){
        test = 1;
    factureCheck = (Facture[]) request.getAttribute("check");
    factureEspece = (Facture[]) request.getAttribute("espece");
    }
%>
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

<!-- start main content -->
<main class="main-container">

	<!-- new collection directory -->
	<section id="content-block" class="slider_area">
		<div class="container">
			<div class="content-push">
				<div class="row">
						<div class="clear"></div>

					</div>

				</div>
			</div>
		</div>
	</section>
	<!-- end new collection directory -->
<section id="popular-product" class="ecommerce">
	<div class="container">
		<!-- Shopping items content -->
		<div class="shopping-content">
			<!-- Block heading two -->
			<div class="block-heading-two">
				<h3><span>LISTES PAYEMENTS</span></h3>
			</div>

			<center>
<br>
  <% 
                    String val="";
                    if(request.getAttribute("erreur")!= null){
                     val=(String)request.getAttribute("erreur");
                    }
                %>
<form action="VoirPaiement" method="get">
    <h4 style="font-family:cursive;width:200px;">DATE DEBUT :</h4>
    <input type="date" style="font-family:cursive;width:200px;" name="date1" class="form-control">
    <br></br>
    <h4 style="font-family:cursive;width:200px;">DATE FIN :</h4>
    <input type="date" style="font-family:cursive;width:200px;" name="date2" class="form-control">
    <br></br>
    <button type="submit" class="btn btn-warning">VOIR RESULTAT</button>
</form>
 <h1><%=val %></h1>
<br>
<table class="table table-bordered" border="2" style="margin-top:20px;">
                                        <!-- Table Header -->
        <thead>
            <tr style="background-color:orange">
                <th style="font-family:cursive;font-size: 15px"  ><center>PAR ESPECES</center></th>           
             </tr>
        </thead>
        <%
            if(test == 1){
                    for(int j = 0; j < factureEspece.length; j++) {
            %>
                <tr>
                  <td style="font-family:cursive;font-size: 15px"><center><%= factureEspece[j].getMontant() %></center></td>
               </tr>                      
          </tbody> 
        <% }} %>
    </table>
<br>
<table class="table table-bordered" border="2" style="margin-top:20px;">
                                        <!-- Table Header -->
        <thead>
            <tr style="background-color:orange">
                <th style="font-family:cursive;font-size: 15px" ><center>PAR CHEQUES</center></th>
               
                
             </tr>
        </thead>
        <%
            if(test == 1){
                for(int i = 0; i < factureCheck.length; i++) {
            %>
                <tr>
                   <td style="font-family:cursive;font-size: 16px;" ><center><span class=""></span><%= factureCheck[i].getMontant() %></center></td>
               </tr>                      
          </tbody> 
        <% }} %>
    </table>
<br>
	</center>
			<br>
			</div>
		</div>
	</div>
</section>


	<!-- End Our Clients  -->

</main>
<%@ include file="content/footer.jsp" %>

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