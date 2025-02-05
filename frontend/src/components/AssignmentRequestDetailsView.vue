<template>

    <v-data-table
        :headers="headers"
        :items="assignmentRequestDetails"
        :items-per-page="5"
        class="elevation-1"
    ></v-data-table>

</template>

<script>
    const axios = require('axios').default;

    export default {
        name: 'AssignmentRequestDetailsView',
        props: {
            value: Object,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            headers: [
                { text: "id", value: "id" },
            ],
            assignmentRequestDetails : [],
        }),
          async created() {
            var temp = await axios.get(axios.fixUrl('/assignmentRequestDetails'))

            temp.data._embedded.assignmentRequestDetails.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])

            this.assignmentRequestDetails = temp.data._embedded.assignmentRequestDetails;
        },
        methods: {
        }
    }
</script>

