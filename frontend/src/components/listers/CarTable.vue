<template>

    <v-data-table
            :headers="headers"
            :items="car"
            :items-per-page="5"
            class="elevation-1"
    ></v-data-table>

</template>

<script>

    export default {
        name: 'CarList',
        props: {
            value: Object,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            headers: [
                { 
                    text: "carId", 
                    value: "carId" 
                },
                { 
                    text: "carModel", 
                    value: "carModel" 
                },
                { 
                    text: "licensePlate", 
                    value: "licensePlate" 
                },
                { 
                    text: "ownerName", 
                    value: "ownerName" 
                },
            ],
            car : [],
        }),
        async created() {
            if(!this.value) this.value = [];
        },
        methods: {
        }
    }
</script>

