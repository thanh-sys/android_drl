$(document).ready(function () {
    $('.main-nav ul.navigation li a').each(function () {
        var isActive = this.pathname === location.pathname;
        $(this).parent().toggleClass('active', isActive);
    });
});