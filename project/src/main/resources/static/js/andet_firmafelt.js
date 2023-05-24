const firmaNavnSelect = document.getElementById('firma_navn');
const andetFirmaFelt = document.getElementById('andet_firmafelt');

firmaNavnSelect.addEventListener('change', function() {
        if (firmaNavnSelect.value === 'andet_firma') {
            andetFirmaFelt.style.display = 'block';
        } else {
            andetFirmaFelt.style.display = 'none';
        }
})