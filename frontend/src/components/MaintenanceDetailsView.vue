<template>

    <v-data-table
        :headers="headers"
        :items="maintenanceDetails"
        :items-per-page="5"
        class="elevation-1"
    ></v-data-table>

</template>

<script>
    const axios = require('axios').default;

    export default {
        name: 'MaintenanceDetailsView',
        props: {
            value: Object,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            headers: [
                { text: "id", value: "id" },
            ],
            maintenanceDetails : [],
        }),
          async created() {
            var temp = await axios.get(axios.fixUrl('/maintenanceDetails'))

            temp.data._embedded.maintenanceDetails.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])

            this.maintenanceDetails = temp.data._embedded.maintenanceDetails;
        },
        methods: {
        }
    }
</script>

