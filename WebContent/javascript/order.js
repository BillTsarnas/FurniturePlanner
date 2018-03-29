$(document).ready(function(){
    $('[data-toggle="tooltip"]').tooltip();
    var actions = $("table td:last-child").html();
    // Append table with add row
    $(".add-new").click(function(){      
        var index = $("table tbody tr:last-child").index();
        var row = '<tr>' +
            '<td><select class="form-control" id="selector"> <option selected>Choose furniture...</option> <option id="kitchen">Kitchen</option> <option id="wardrobe">Wardrobe</option> <option id="door">Door</option> <option id="other">Other</option> </select></td>' +
            '<td><input type="text" id="productid" class="form-control" name="ProductID" id="productID"></td>' +
            '<td><select class="form-control" id="selector"> <option selected>Choose status...</option> <option id="active">Active</option> <option id="postponed">Postponed</option> <option id="inactive">Inactive</option> <option id="cancelled">Cancelled</option> </select></td>' +
            '<td><input type="text" id="status" class="form-control" name="phone" id="status"></td>' +
            '<td>' + actions + '</td>' +
        '</tr>';
        $("table").append(row);     
        $("table tbody tr").eq(index + 1).find(" .add").toggle();
        $('[data-toggle="tooltip"]').tooltip();
    });

    //Delete row
    $(document).on("click", ".delete", function(){
        $(this).parents("tr").remove();
        $(".add-new").removeAttr("disabled");
    });

});