<template>
    <v-card outlined>
        <v-card-title>
            CreateExpense
        </v-card-title>

        <v-card-text>
            <VehicleId offline label="VehicleId" v-model="value.vehicleId" :editMode="editMode" @change="change"/>
            <ExpenseType offline label="ExpenseType" v-model="value.expenseType" :editMode="editMode" @change="change"/>
            <Money offline label="Amount" v-model="value.amount" :editMode="editMode" @change="change"/>
            <Date label="Date" v-model="value.date" :editMode="editMode"/>
            <String label="Description" v-model="value.description" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="primary"
                    text
                    @click="createExpense"
            >
                CreateExpense
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
        name: 'CreateExpenseCommand',
        components:{},
        props: {},
        data: () => ({
            editMode: true,
            value: {},
        }),
        created() {
            this.value.vehicleId = {};
            this.value.expenseType = {};
            this.value.amount = {};
            this.value.date = '2025-02-05';
            this.value.description = '';
        },
        watch: {
        },
        methods: {
            createExpense() {
                this.$emit('createExpense', this.value);
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

