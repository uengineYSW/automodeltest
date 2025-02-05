<template>

    <v-data-table
        :headers="headers"
        :items="operationDetails"
        :items-per-page="5"
        class="elevation-1"
    ></v-data-table>

</template>

<script>
    const axios = require('axios').default;

    export default {
        name: 'OperationDetailsView',
        props: {
            value: Object,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            headers: [
                { text: "id", value: "id" },
            ],
            operationDetails : [],
        }),
          async created() {
            var temp = await axios.get(axios.fixUrl('/operationDetails'))

            temp.data._embedded.operationDetails.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])

            this.operationDetails = temp.data._embedded.operationDetails;
        },
        methods: {
        }
    }
</script>

