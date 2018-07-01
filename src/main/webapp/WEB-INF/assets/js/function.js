
// function timestamp(){
// 	return Number(new Date());
// }

// function sorting(obj, prop, asc){
// 	obj = obj.sort(function(a, b){
// 		if (asc) return (a[prop] > b[prop]) ? 1 : ((a[prop] < b[prop]) ? -1 : 0);
// 		else return (b[prop] > a[prop]) ? 1 : ((b[prop] < a[prop]) ? -1 : 0);
// 	});
// 	return obj;
// }

// function enter2tab(){
// 	$('input')
// 	.not($('.login-area input'))
// 	.not($('.search-area input'))
// 	.on('keypress', function(e){
// 		if(e.keyCode == 13){
// 			var inputs = $(this).parents("form").eq(0).find(":input");
// 			var idx = inputs.index(this);

// 			if (idx == inputs.length - 1){
// 				inputs[0].select()
// 			}else{
// 				inputs[idx + 1].focus();
// 				inputs[idx + 1].select();
// 			}
// 			return false;
// 		}
// 	});
// }

function onResize(){
	var pWidth = $(window).width();
	var pHeight = $(window).height();
	var wWidth = $('.login-area').width();
	var wHeight = $('.login-area').height();
	wWidth += 2;
	wHeight += 62;
	var wMarginLeft = 0;
	var wMarginTop = 0;
	if( pWidth > 767 ){
		if( wWidth < pWidth ){
			wMarginLeft = (pWidth-wWidth)/2;
		}
		if( wHeight < pHeight ){
			wMarginTop = (pHeight-wHeight)/2;
		}
	}
	$('.login-area').css('marginLeft', wMarginLeft);
	$('.login-area').css('marginTop', wMarginTop);

}

$(function(){

	// /*--------- init ---------*/
	// $('[data-toggle="tooltip"]').tooltip();
	// $('.chosen-select').chosen({
	// 	allow_single_deselect: true
	// });

	// var validator = $('form').validate();
	// enter2tab();
	// // $("input:text").focus(function(){
	// // 	$(this).select();
	// // });

	// /*--------- product ---------*/
	// $('.box-bg').on('mouseenter', function(){
	// 	$(this).find('.box-function-area').fadeIn();
	// }).on('mouseleave', function(){
	// 	$(this).find('.box-function-area').css('display', 'none');
	// });

	// /*--------- menu-area ---------*/
	// $('.header-area h1').on('click', function(){
	// 	$('.menu-area').slideToggle();
	// });
	
	// /*--------- timeout ---------*/
	// var timeOutHandler;
	// $('.header-area').bind('mouseover', function(){
	// 	clearTimeout(timeOutHandler);
	// });
	// $('.header-area').bind('mouseleave', function(){
	// 	timeOutHandler = setTimeout(function(){
	// 		$('.menu-area').slideUp();
	// 	}, 529);
	// });
	
	// /*--------- on resize ---------*/
	// $(window).resize(function(){
	// 	$('.chosen-container').attr('style', 'width:100%');
	// });
	// $(window).trigger('resize');
	
	// /*--------- on submit ---------*/
	// // $('input[type="submit"].onbeforeunloadreturn').on('click', function(){
	// // 	$('body').attr('onbeforeunload', '');
	// // });

	// /*--------- on submit ---------*/
	// /*--------- very important ---------*/
	// $('form').submit(function(){
	// 	if($.isEmptyObject(validator.invalid)){
	// 		$(':submit').css('display', 'none', function(){
	// 			return true;
	// 		});
	// 	}
	// });

	// --------- chosen onclick ---------
	// // $('.refresh-chosen').on('click', function(){
	// // 	$('.chosen-select').empty(); //remove all child nodes
	// // 	var newOption = $('<option value></option><option value="1">test</option>');
	// // 	$('.chosen-select').append(newOption);
	// // 	$('.chosen-select').trigger("chosen:updated");
	// // });
	
	// /*--------- list onclick ---------*/
	// // $(document).on('click', 'table.list tr td.expandable', function(){
	// // 	thisTableId = $(this).parent().parent().parent().attr('id');
	// // 	thisTrId = $(this).parent();
	// // 	thisRecordId = $(thisTrId).attr('id');
	// // 	if($(thisTrId).hasClass('contract')){
	// // 		$(thisTrId).removeClass('contract').addClass('expand');
	// // 		$(thisTrId).after('<tr class="detail"><td colspan="'+$(thisTrId).children().length+'"><div id="'+thisTableId+'-'+thisRecordId+'"><ul><li class="corpcolor-font">Loading...</li></ul></div></td></tr>');
	// // 		$('#'+thisTableId+'-'+thisRecordId).load('/crm/load', {'thisTableId': thisTableId, 'thisRecordId': thisRecordId, 't': timestamp()});
	// // 	}else if($(thisTrId).hasClass('expand')){
	// // 		$(thisTrId).removeClass('expand').addClass('contract');
	// // 		$(thisTrId).next().remove();
	// // 	}
	// // });
	// $('.modal-btn').on('click', function(){
	// 	thisTableId = $(this).parent().parent().parent().parent().attr('id');
	// 	thisRecordId = $(this).attr('rel');
	// 	$('.modal-body').load('/topexcellent/load/', {'thisTableId': thisTableId, 'thisRecordId': thisRecordId, 't': timestamp()});
	// });






	
	onResize();
	$(window).resize(function(){
		onResize();
	});


	/*--------- date mask ---------*/
	$('.date-mask').mask('9999-99-99');

	/*--------- datetimepicker ---------*/
	$('.datetimepicker').datetimepicker({
		format: 'Y-MM-DD'
	});
	
});
