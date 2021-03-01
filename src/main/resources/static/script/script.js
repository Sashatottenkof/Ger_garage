
// .ready executes functions as soon as a page gets loaded
$(document).ready(function(){



//datepicker
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





//calls function on start
totalPrice();
//call function on change
$('#serviceOption').change(totalPrice);




//users bookings table
    $('#myBookingsTable').DataTable( {
        "scrollX": true
    } );
//user vehicles table
    $('#myVehiclesTable').DataTable( {
        "scrollX": true
    } );

//all bookings for admin table
    $('#allBookingsTable').DataTable( {
        "scrollX": true
    } );
//table of items
    $('#tableItems').DataTable( {
        "scrollX": true
    } );
})






// the function changes the total price depends on th chousen option
function totalPrice() {
        let TotalPrice= ($('#serviceOption').find(':selected').data('price'));
        $('#totalPrice').text(TotalPrice);

};




