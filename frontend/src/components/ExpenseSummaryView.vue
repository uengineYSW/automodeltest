<template>

    <v-data-table
        :headers="headers"
        :items="expenseSummary"
        :items-per-page="5"
        class="elevation-1"
    ></v-data-table>

</template>

<script>
    const axios = require('axios').default;

    export default {
        name: 'ExpenseSummaryView',
        props: {
            value: Object,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            headers: [
                { text: "id", value: "id" },
            ],
            expenseSummary : [],
        }),
          async created() {
            var temp = await axios.get(axios.fixUrl('/expenseSummaries'))

            temp.data._embedded.expenseSummaries.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])

            this.expenseSummary = temp.data._embedded.expenseSummaries;
        },
        methods: {
        }
    }
</script>

