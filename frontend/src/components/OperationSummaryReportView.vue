<template>

    <v-data-table
        :headers="headers"
        :items="operationSummaryReport"
        :items-per-page="5"
        class="elevation-1"
    ></v-data-table>

</template>

<script>
    const axios = require('axios').default;

    export default {
        name: 'OperationSummaryReportView',
        props: {
            value: Object,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            headers: [
                { text: "id", value: "id" },
            ],
            operationSummaryReport : [],
        }),
          async created() {
            var temp = await axios.get(axios.fixUrl('/operationSummaryReports'))

            temp.data._embedded.operationSummaryReports.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])

            this.operationSummaryReport = temp.data._embedded.operationSummaryReports;
        },
        methods: {
        }
    }
</script>

