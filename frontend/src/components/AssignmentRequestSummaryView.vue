<template>

    <v-data-table
        :headers="headers"
        :items="assignmentRequestSummary"
        :items-per-page="5"
        class="elevation-1"
    ></v-data-table>

</template>

<script>
    const axios = require('axios').default;

    export default {
        name: 'AssignmentRequestSummaryView',
        props: {
            value: Object,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            headers: [
                { text: "id", value: "id" },
            ],
            assignmentRequestSummary : [],
        }),
          async created() {
            var temp = await axios.get(axios.fixUrl('/assignmentRequestSummaries'))

            temp.data._embedded.assignmentRequestSummaries.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])

            this.assignmentRequestSummary = temp.data._embedded.assignmentRequestSummaries;
        },
        methods: {
        }
    }
</script>

