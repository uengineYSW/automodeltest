<template>
    <v-card outlined>
        <v-card-title>
            CreateOperationRecord
        </v-card-title>

        <v-card-text>
            <Number label="OperationId" v-model="value.operationId" :editMode="editMode"/>
            <Driver offline label="Driver" v-model="value.driver" :editMode="editMode" @change="change"/>
            <Date label="TravelDate" v-model="value.travelDate" :editMode="editMode"/>
            <String label="Departure" v-model="value.departure" :editMode="editMode"/>
            <String label="Destination" v-model="value.destination" :editMode="editMode"/>
            <Number label="TravelDistance" v-model="value.travelDistance" :editMode="editMode"/>
            <TravelDuration offline label="TravelDuration" v-model="value.travelDuration" :editMode="editMode" @change="change"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="primary"
                    text
                    @click="createOperationRecord"
            >
                CreateOperationRecord
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
        name: 'CreateOperationRecordCommand',
        components:{},
        props: {},
        data: () => ({
            editMode: true,
            value: {},
        }),
        created() {
            this.value.operationId = 0;
            this.value.driver = {};
            this.value.travelDate = '2025-02-05';
            this.value.departure = '';
            this.value.destination = '';
            this.value.travelDistance = 0;
            this.value.travelDuration = {};
        },
        watch: {
        },
        methods: {
            createOperationRecord() {
                this.$emit('createOperationRecord', this.value);
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

