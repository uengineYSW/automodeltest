<template>
    <v-card outlined>
        <v-card-title>
            CancelAssignmentRequest
        </v-card-title>

        <v-card-text>
            <Number label="RequestId" v-model="value.requestId" :editMode="editMode"/>
            <String label="CancellationReason" v-model="value.cancellationReason" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="primary"
                    text
                    @click="cancelAssignmentRequest"
            >
                CancelAssignmentRequest
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
        name: 'CancelAssignmentRequestCommand',
        components:{},
        props: {},
        data: () => ({
            editMode: true,
            value: {},
        }),
        created() {
            this.value.requestId = 0;
            this.value.cancellationReason = '';
        },
        watch: {
        },
        methods: {
            cancelAssignmentRequest() {
                this.$emit('cancelAssignmentRequest', this.value);
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

