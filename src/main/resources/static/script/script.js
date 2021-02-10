//$(document).ready(function(){
//
//$("#test").hover(function(){alert("Hello! I am an alert box!!")});
//
//})


//function myFunction() {
//    alert("Hello! I am an alert box!");
//  }
//
//  window.onload = function() {
//
//      alert( "welcome" );
//
//  };


//datepicker
$(document).ready(function(){


//Restricts user for choosing specific dates in datetime picker
   $('#datetimepicker1').datetimepicker({
<!--        disabledDates: disabledDate,-->
        format: 'YYYY-MM-DD',
<!--    enabledDates: ["9-6-2020","14-6-2020","15-6-2020"],-->
           minDate:new Date(),
        daysOfWeekDisabled: [0, 7],

<!--        enabledHours:['13','14']-->
<!--      disabledHours: ['0', '1', '2', '3', '4', '5', '6', '7', '8', '18', '19', '20', '21', '22', '23']-->
<!--       hoursDisabled: ['0', '1', '2', '3', '4', '5', '6', '7', '8', '18', '19', '20', '21', '22', '23']-->
    });

    })
