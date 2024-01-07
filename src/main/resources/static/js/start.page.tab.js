$(document).ready(function(){
    if(hash = window.location.hash ) {
        $('a[href="' + hash + '"]').click();
    }
});