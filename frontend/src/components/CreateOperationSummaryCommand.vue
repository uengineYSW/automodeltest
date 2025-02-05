<template>
    <v-card outlined>
        <v-card-title>
            CreateOperationSummary
        </v-card-title>

        <v-card-text>
            <Number label="SummaryId" v-model="value.summaryId" :editMode="editMode"/>
            <Number label="TotalOperations" v-model="value.totalOperations" :editMode="editMode"/>
            <Number label="TotalDistance" v-model="value.totalDistance" :editMode="editMode"/>
            <Number label="AverageDistance" v-model="value.averageDistance" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="primary"
                    text
                    @click="createOperationSummary"
            >
                CreateOperationSummary
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
        name: 'CreateOperationSummaryCommand',
        components:{},
        props: {},
        data: () => ({
            editMode: true,
            value: {},
        }),
        created() {
            this.value.summaryId = 0;
            this.value.totalOperations = 0;
            this.value.totalDistance = 0;
            this.value.averageDistance = 0;
        },
        watch: {
        },
        methods: {
            createOperationSummary() {
                this.$emit('createOperationSummary', this.value);
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

