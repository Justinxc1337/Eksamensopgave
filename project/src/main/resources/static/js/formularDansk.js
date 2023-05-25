window.onscroll = function() { myFunction() };

var navbar = document.getElementById("navbar");
var sticky = navbar.offsetTop;

function myFunction() {
    if (window.pageYOffset >= sticky) {
        navbar.classList.add("sticky");
    } else {
        navbar.classList.remove("sticky");
    }
}

const firmaNavnSelect = document.querySelector('.drop-down');
    const andetFirmaFelt = document.getElementById('andet_firmafelt');

    firmaNavnSelect.addEventListener('change', function() {
        if (firmaNavnSelect.value === 'andet firma') {
            andetFirmaFelt.style.display = 'block';
        } else {
            andetFirmaFelt.style.display = 'none';
        }
    })

    window.onscroll = function() { myFunction() };

    var navbar = document.getElementById("navbar");
    var sticky = navbar.offsetTop;

    function myFunction() {
        if (window.pageYOffset >= sticky) {
            navbar.classList.add("sticky");
        } else {
            navbar.classList.remove("sticky");
        }
    }