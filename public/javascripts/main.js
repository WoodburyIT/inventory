$(function(){
	$(".date-picker").each(function(){
		$(this).appendDtpicker({
			"inline": false,
			"closeOnSelected": true,
			"autodateOnStart": false
		});
	})
	
	$(".asset-to-cart").click(function() {
		var assetId = $(this).parents(".asset-info").find(".assetId").text();
		$.get("/addAssetToCart?assetId=" + assetId, function(data) {
		});
	});
	$(".customer-to-cart").click(function() {
		var customerId = $(this).parents(".customer-info").find(".customerId").text();
		
		$.get("/assignCustomerToCart?customerId=" + customerId, function(data) {
		});
	});
	$(".asset-from-cart").click(function() {
		var assetId = $(this).parents(".asset-info").find(".assetId").text();
		$.get("/removeAssetFromCart?assetId=" + assetId, function(data) {
		});
	});
	$(".customer-from-cart").click(function() {
		$.get("/removeCustomerFromCart", function(data) {
		});
	});
	
	//********************** From checkout list
	
	$('#overdue-checkouts-table').DataTable();
	$('#midtable').DataTable();
	$('#bottable').DataTable();
	
	$(".selectable-table").each(function() {
		$(this).DataTable();
	})
	
	$('.selectable-table tbody').on( 'click', 'td', function () {
        $(this).toggleClass('selected');
    } );
	
	//*************** Asset List*/
	
	$(".asset-info .addButton").on("click", function(){
		var assetId = $(this).parents(".asset-info").find(".assetId").text();
		$.get("/addAssetToCart?assetId=" + assetId, function() {
			$("#rightcolumn").load("/viewCart");
		});
	});
	
});


var ck_nameType = /^[A-Za-z0-9 \-]{1,50}$/;
var ck_number = /^[A-Za-z0-9 \-]{0,25}$/;
var ck_MM = /^(0?[1-9]|1[012]|)$/;
var ck_DD = /^(0[1-9]|[12]\d|3[01]|)$/;
var ck_YYYY = /^[0-9]{0,4}|$/;

function validate()
{

  if( document.createCheckoutAssetForm.name.value == "" )
   {
      alert( "Asset Name required!" );
      document.createCheckoutAssetForm.name.focus() ;
      return false;
   }
  
   if (!ck_nameType.test(document.createCheckoutAssetForm.name.value))
   {
      alert( "Invalid Characters Detected! Allowed characters include letters, numbers, spaces, and hyphens." );
      document.createCheckoutAssetForm.name.focus() ;
      return false;
   }
  
   if( document.createCheckoutAssetForm.assetType.value == "" )
   {
      alert( "Asset Type required!" );
      document.createCheckoutAssetForm.assetType.focus() ;
      return false;
   }
  
  if (!ck_nameType.test(document.createCheckoutAssetForm.assetType.value))
   {
      alert( "Invalid Characters Detected! Allowed characters include letters, numbers, spaces, and hyphens." );
      document.createCheckoutAssetForm.assetType.focus() ;
      return false;
   }
  
  if (!ck_number.test(document.createCheckoutAssetForm.inventoryNumber.value))
   {
      alert( "Invalid Characters Detected! Allowed characters include letters, numbers, spaces, and hyphens." );
      document.createCheckoutAssetForm.inventoryNumber.focus() ;
      return false;
   }
  
  if (!ck_MM.test(document.createCheckoutAssetForm.element_3_1.value))
   {
      alert( "Enter a valid month." );
      document.createCheckoutAssetForm.element_3_1.focus() ;
      return false;
   }
  
  if (!ck_DD.test(document.createCheckoutAssetForm.element_3_2.value))
   {
      alert( "Enter a valid day." );
      document.createCheckoutAssetForm.element_3_2.focus() ;
      return false;
   }
  
  if (!ck_YYYY.test(document.createCheckoutAssetForm.element_3_3.value))
   {
      alert( "Enter a valid year" );
      document.createCheckoutAssetForm.element_3_3.focus() ;
      return false;
   }
	 
           
   return( true );
}




