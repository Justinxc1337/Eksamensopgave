const firmaNavnSelect = document.querySelector('.drop-down');
const andetFirmaFelt = document.getElementById('andet_firmafelt');

firmaNavnSelect.addEventListener('change', function() {
    if (firmaNavnSelect.value === 'andet firma') {
        andetFirmaFelt.style.display = 'block';
    } else {
        andetFirmaFelt.style.display = 'none';
    }
})