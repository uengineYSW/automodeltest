<template>

    <v-data-table
        :headers="headers"
        :items="operationRecordDetails"
        :items-per-page="5"
        class="elevation-1"
    ></v-data-table>

</template>

<script>
    const axios = require('axios').default;

    export default {
        name: 'OperationRecordDetailsView',
        props: {
            value: Object,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            headers: [
                { text: "id", value: "id" },
            ],
            operationRecordDetails : [],
        }),
          async created() {
            var temp = await axios.get(axios.fixUrl('/operationRecordDetails'))

            temp.data._embedded.operationRecordDetails.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])

            this.operationRecordDetails = temp.data._embedded.operationRecordDetails;
        },
        methods: {
        }
    }
</script>

