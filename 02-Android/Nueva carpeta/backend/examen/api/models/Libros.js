module.exports = {
    attributes: {
        icbn: {
            type: "number"
        },
        nombre: {
            type: "string"
        },
        numPaginas: {
            type: "number"
        },
        edicion: {
            type: "number"
        },
        fechaPublicacion: {
            type: "string"
        },
        nombreEditorial: {
            type: "string"
        },
        idAutor: {
            model: "Autores"
        }
    },
};