<template>
    <v-card outlined>
        <v-card-title>
            RegisterMaintenance
        </v-card-title>

        <v-card-text>
            <Number label="RecordId" v-model="value.recordId" :editMode="editMode"/>
            <String label="CarId" v-model="value.carId" :editMode="editMode"/>
            <MaintenanceDetail offline label="MaintenanceDetails" v-model="value.maintenanceDetails" :editMode="editMode" @change="change"/>
            <Date label="MaintenanceDate" v-model="value.maintenanceDate" :editMode="editMode"/>
            <MaintenanceStatus offline label="Status" v-model="value.status" :editMode="editMode" @change="change"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="primary"
                    text
                    @click="registerMaintenance"
            >
                RegisterMaintenance
            </v-btn>
            
            <v-btn
                    color="primary"
                    text
                    @click="close"
            >
                Close
            </v-btn>
        </v-card-actions>
    </v-card>

</template>

<script>
   
    export default {
        name: 'RegisterMaintenanceCommand',
        components:{},
        props: {},
        data: () => ({
            editMode: true,
            value: {},
        }),
        created() {
            this.value.recordId = 0;
            this.value.carId = '';
            this.value.maintenanceDetails = {};
            this.value.maintenanceDate = '2025-02-05';
            this.value.status = {};
        },
        watch: {
        },
        methods: {
            registerMaintenance() {
                this.$emit('registerMaintenance', this.value);
            },
            close() {
                this.$emit('closeDialog');
            },
            change() {
                this.$emit('input', this.value);
            },
        }
    }
</script>

