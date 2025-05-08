document.addEventListener('DOMContentLoaded', () => {
    const addMaterialBtn = document.getElementById('addMaterial');
    const modal = document.getElementById('addMaterialModal');
    const closeBtn = document.querySelector('.close');
    const form = document.getElementById('addMaterialForm');

    addMaterialBtn.addEventListener('click', () => {
        modal.style.display = 'block';
    });

    closeBtn.addEventListener('click', () => {
        modal.style.display = 'none';
    });
    window.addEventListener('click', (event) => {
        if (event.target === modal) {
            modal.style.display = 'none';
        }
    });

});
