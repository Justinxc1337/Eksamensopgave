
function registerDateTime() {
    var currentDate = new Date().toISOString();
    document.getElementById('indtjekningstidspunkt').value = currentDate;
    redirectToRegistreretDansk();
}
function redirectToRegistreretDansk() {
    window.location.href = '/registreretDansk';
}


