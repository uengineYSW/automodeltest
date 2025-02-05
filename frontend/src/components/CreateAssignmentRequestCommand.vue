<template>
    <v-card outlined>
        <v-card-title>
            CreateAssignmentRequest
        </v-card-title>

        <v-card-text>
            <Number label="RequestId" v-model="value.requestId" :editMode="editMode"/>
            <Number label="UserId" v-model="value.userId" :editMode="editMode"/>
            <VehicleType offline label="VehicleType" v-model="value.vehicleType" :editMode="editMode" @change="change"/>
            <Date label="RequestDate" v-model="value.requestDate" :editMode="editMode"/>
            <RequestStatus offline label="Status" v-model="value.status" :editMode="editMode" @change="change"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="primary"
                    text
                    @click="createAssignmentRequest"
            >
                CreateAssignmentRequest
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
        name: 'CreateAssignmentRequestCommand',
        components:{},
        props: {},
        data: () => ({
            editMode: true,
            value: {},
        }),
        created() {
            this.value.requestId = 0;
            this.value.userId = 0;
            this.value.vehicleType = {};
            this.value.requestDate = '2025-02-05';
            this.value.status = {};
        },
        watch: {
        },
        methods: {
            createAssignmentRequest() {
                this.$emit('createAssignmentRequest', this.value);
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

