<template>

    <v-data-table
        :headers="headers"
        :items="maintenanceHistory"
        :items-per-page="5"
        class="elevation-1"
    ></v-data-table>

</template>

<script>
    const axios = require('axios').default;

    export default {
        name: 'MaintenanceHistoryView',
        props: {
            value: Object,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            headers: [
                { text: "id", value: "id" },
            ],
            maintenanceHistory : [],
        }),
          async created() {
            var temp = await axios.get(axios.fixUrl('/maintenanceHistories'))

            temp.data._embedded.maintenanceHistories.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])

            this.maintenanceHistory = temp.data._embedded.maintenanceHistories;
        },
        methods: {
        }
    }
</script>

