function deleteBus(path, id) {
    if (confirm("Are you sure to delete?") === true) {
        fetch(path, {
            method: "delete"
        }).then(res => {
            if (res.status === 204) {
                location.reload();
            } else {
                alert("Delete Fail");
            }
        });
    }
}
