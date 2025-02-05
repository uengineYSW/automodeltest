<template>

    <v-data-table
        :headers="headers"
        :items="operationRecordSummary"
        :items-per-page="5"
        class="elevation-1"
    ></v-data-table>

</template>

<script>
    const axios = require('axios').default;

    export default {
        name: 'OperationRecordSummaryView',
        props: {
            value: Object,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            headers: [
                { text: "id", value: "id" },
            ],
            operationRecordSummary : [],
        }),
          async created() {
            var temp = await axios.get(axios.fixUrl('/operationRecordSummaries'))

            temp.data._embedded.operationRecordSummaries.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])

            this.operationRecordSummary = temp.data._embedded.operationRecordSummaries;
        },
        methods: {
        }
    }
</script>

