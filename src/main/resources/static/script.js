//(function () {
//    var price;
//
//    $("booking.type").on ('focus' ,function () {
//        // Store the current value on focus, before it changes
//        price = this.value;
//    }).change(function() {
//        // Do soomething with the previous value after the change
//        document.getElementById("booking.price").innerHTML = price;
//
//        price = this.value;
//    });
//})();

//(function () {
// var price = $("booking.type.price").(":selected").val();
//  //    var price = document.getElementById('booking.type').text();
//     document.getElementById("booking.price") = price;
//
//    });
//(function () {
// var price = $("booking.type.price").(":selected").val();
//  //    var price = document.getElementById('booking.type').text();
//     document.getElementById("booking.price") = price;
//
//    });


//<!--  <script th:inline="javascript">-->
//<!--/*<![CDATA[*/-->
//<!--    ...-->
//
//<!--    var price = /*[[${typeService.price}]]*/;-->
//<!--    /*[[${booking.price}]]*/ = price-->
//<!--    ...-->
//<!--/*]]>*/-->
//<!--</script>-->
//
///* initialize the calendar
//-----------------------------------------------------------------*/
//
//var date = new Date();
//var d = date.getDate();
//var m = date.getMonth();
//var y = date.getFullYear();
//var className = Array('fc-primary', 'fc-danger', 'fc-default', 'fc-success', 'fc-info', 'fc-warning', 'fc-danger-solid', 'fc-warning-solid', 'fc-success-solid', 'fc-default-solid', 'fc-success-solid', 'fc-primary-solid');
//
//$calendar = $('#calendar');
//$calendar.fullCalendar({
//	header: {
//		left: 'prev,next today',
//		center: 'title',
//		right: 'month,agendaWeek,agendaDay,listWeek'
//	},
//	selectable : true,
//	selectHelper: true,
//	select: function(start, end) {
//
//		// on select we show the Sweet Alert modal with an input
//		swal({
//			title: 'Create an Event',
//			html: '',
//			content: {
//				element: "input",
//				attributes: {
//					placeholder: "Event Title",
//					type: "text",
//					id: "input-field",
//					className: "form-control"
//				},
//			},
//			buttons: {
//				cancel: true,
//				confirm: true,
//			},
//		}).then(
//		function() {
//			var eventData;
//			var classRandom = className[Math.floor(Math.random()*className.length)];
//			event_title = $('#input-field').val();
//
//			if (event_title) {
//				eventData = {
//					title: event_title,
//					start: start,
//					className: classRandom,
//					end: end
//				};
//				$calendar.fullCalendar('renderEvent', eventData, true); // stick? = true
//			}
//
//			$calendar.fullCalendar('unselect');
//		}
//		);
//	},
//	events: [
//	{
//		title: 'All Day Event',
//		start: new Date(y, m, 1),
//		className: 'fc-default'
//	},
//	{
//		id: 999,
//		title: 'Repeating Event',
//		start: new Date(y, m, d - 3, 16, 0),
//		allDay: false,
//		className: 'fc-warning'
//	},
//	{
//		id: 999,
//		title: 'Repeating Event',
//		start: new Date(y, m, d + 4, 16, 0),
//		allDay: false,
//		className: 'fc-info'
//	},
//	{
//		title: 'Meeting',
//		start: new Date(y, m, d, 10, 30),
//		allDay: false,
//		className: 'fc-danger'
//	},
//	{
//		title: 'Lunch',
//		start: new Date(y, m, d, 12, 0),
//		end: new Date(y, m, d, 14, 0),
//		allDay: false,
//		className: 'fc-primary',
//		description: 'Eat Bro'
//	},
//	{
//		title: 'Meeting',
//		start: new Date(y, m, d + 3, 13, 30),
//		allDay: false,
//		className: 'fc-primary-solid',
//		description: 'Meeting'
//	},
//	{
//		title: 'Birthday Party',
//		start: new Date(y, m, d + 1, 19, 0),
//		end: new Date(y, m, d + 1, 22, 30),
//		allDay: false,
//		className: 'fc-success',
//		description: 'Coba Googling dulu'
//	},
//	{
//		title: 'Lunch',
//		start: new Date(y, m, d + 6, 13, 30),
//		allDay: false,
//		className: 'fc-success-solid',
//		description: 'Lunch'
//	},
//	{
//		title: 'Click for Google',
//		start: new Date(y, m, 28),
//		end: new Date(y, m, 29),
//		allDay: false,
//		url: 'http://google.com/',
//		className: 'fc-info-solid',
//	}
//	],
//
//
//});
