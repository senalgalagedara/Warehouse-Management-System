document.querySelectorAll('.edit').forEach(button => {
    button.addEventListener('click', function () {
        alert('Edit button clicked!');
    });
});

document.querySelectorAll('.delete').forEach(button => {
    button.addEventListener('click', function () {
        alert('Delete button clicked!');
    });
});
// Get modal elements
//const modal = document.getElementById("addSupplierModal");
//const addSupplierBtn = document.getElementById("addSupplier");
const closeBtn = document.querySelector(".close");

// Open modal when "Add Supplier" button is clicked
addSupplierBtn.addEventListener("click", () => {
    modal.style.display = "flex";
});

// Close modal when "x" button is clicked
closeBtn.addEventListener("click", () => {
    modal.style.display = "none";
});

// Close modal when clicking outside the modal content
window.addEventListener("click", (event) => {
    if (event.target === modal) {
        modal.style.display = "none";
    }
});

// Handle form submission
/*document.getElementById("addSupplierFormm").addEventListener("submit", (event) => {
    event.preventDefault(); // Prevent page reload
    alert("Supplier added successfully!");
    modal.style.display = "none"; // Close modal after submission
});
*/
