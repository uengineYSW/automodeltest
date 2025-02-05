<template>
    <v-card outlined>
        <v-card-title>
            UpdateAssignmentRequest
        </v-card-title>

        <v-card-text>
            <Number label="RequestId" v-model="value.requestId" :editMode="editMode"/>
            <VehicleType offline label="VehicleType" v-model="value.vehicleType" :editMode="editMode" @change="change"/>
            <Date label="RequestDate" v-model="value.requestDate" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="primary"
                    text
                    @click="updateAssignmentRequest"
            >
                UpdateAssignmentRequest
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
        name: 'UpdateAssignmentRequestCommand',
        components:{},
        props: {},
        data: () => ({
            editMode: true,
            value: {},
        }),
        created() {
            this.value.requestId = 0;
            this.value.vehicleType = {};
            this.value.requestDate = '2025-02-05';
        },
        watch: {
        },
        methods: {
            updateAssignmentRequest() {
                this.$emit('updateAssignmentRequest', this.value);
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

