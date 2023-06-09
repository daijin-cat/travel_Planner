$(document).ready(function() {
    const wrapper = $('.wrapper');
    const loginLink = $('.login-link');
    const registerLink = $('.register-link');
    const btnPopup = $('.btnLogin-popup');
    const iconClose = $('.icon-close');

    registerLink.click(function() {
        wrapper.addClass('active');
    });

    loginLink.click(function() {
        wrapper.removeClass('active');
    });

    btnPopup.click(function() {
        wrapper.addClass('active-popup');
    });

    iconClose.click(function() {
        wrapper.removeClass('active-popup');
    });
});