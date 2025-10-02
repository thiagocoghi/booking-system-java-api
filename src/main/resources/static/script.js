// Criar reserva
document.getElementById("reservaForm")?.addEventListener("submit", function(e) {
    e.preventDefault();
    const formData = new FormData(e.target);
    const reserva = Object.fromEntries(formData.entries());

    fetch("/reservas", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(reserva)
    })
    .then(res => res.json())
    .then(data => {
        alert("Reserva criada com sucesso!");
        e.target.reset();
    })
    .catch(err => alert("Erro ao criar reserva"));
});

// Listar reservas
if (document.getElementById("tabelaReservas")) {
    fetch("/reservas")
        .then(res => res.json())
        .then(reservas => {
            const tbody = document.querySelector("#tabelaReservas tbody");
            reservas.forEach(r => {
                const row = `<tr>
                    <td>${r.id}</td>
                    <td>${r.cliente}</td>
                    <td>${r.recurso}</td>
                    <td>${r.dataInicio}</td>
                    <td>${r.dataFim}</td>
                </tr>`;
                tbody.innerHTML += row;
            });
        });
}