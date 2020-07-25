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


<!--  <script th:inline="javascript">-->
<!--/*<![CDATA[*/-->
<!--    ...-->

<!--    var price = /*[[${typeService.price}]]*/;-->
<!--    /*[[${booking.price}]]*/ = price-->
<!--    ...-->
<!--/*]]>*/-->
<!--</script>-->