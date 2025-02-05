<template>

    <v-data-table
        :headers="headers"
        :items="expenseDetails"
        :items-per-page="5"
        class="elevation-1"
    ></v-data-table>

</template>

<script>
    const axios = require('axios').default;

    export default {
        name: 'ExpenseDetailsView',
        props: {
            value: Object,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            headers: [
                { text: "id", value: "id" },
            ],
            expenseDetails : [],
        }),
          async created() {
            var temp = await axios.get(axios.fixUrl('/expenseDetails'))

            temp.data._embedded.expenseDetails.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])

            this.expenseDetails = temp.data._embedded.expenseDetails;
        },
        methods: {
        }
    }
</script>

