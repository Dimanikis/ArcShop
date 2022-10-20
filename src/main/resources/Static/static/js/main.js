$(document).ready(function(){
    $.getJSON('/acc/logviagoogle', function(data) {
        $('#login').text(data.email);
        $('#avatar').attr("src", data.pictureUrl);
    });
});




