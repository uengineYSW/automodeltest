<template>

    <v-card outlined>
        <v-card-title>
            MetricsDetails
        </v-card-title>

        <v-card-text>
            <Number label="TotalOperations" v-model="value.totalOperations" :editMode="editMode"/>
            <Number label="TotalDistance" v-model="value.totalDistance" :editMode="editMode"/>
            <Number label="AverageDistance" v-model="value.averageDistance" :editMode="editMode"/>
            <Money offline label="Money" v-model="value.money" :editMode="editMode" @change="change"/>
        </v-card-text>

        <v-card-actions v-if="inList">
            <slot name="actions"></slot>
        </v-card-actions>
    </v-card>
</template>

<script>

    export default {
        name: 'MetricsDetails',
        components:{},
        props: {
            value: [Object, String, Number, Boolean, Array],
            editMode: Boolean,
            isNew: Boolean,
            offline: Boolean,
            inList: Boolean,
            label: String,
        },
        data: () => ({
        }),
        async created() {
            if(!Object.values(this.value)[0]) {
                this.$emit('input', {});
                this.newValue = {
                    'totalOperations': '',
                    'totalDistance': '',
                    'averageDistance': '',
                    'money': '',
                }
            }
            if(typeof this.value === 'object') {
                if(!('totalOperations' in this.value)) {
                    this.value.totalOperations = 0;
                }
            }
            if(typeof this.value === 'object') {
                if(!('totalDistance' in this.value)) {
                    this.value.totalDistance = 0;
                }
            }
            if(typeof this.value === 'object') {
                if(!('averageDistance' in this.value)) {
                    this.value.averageDistance = 0;
                }
            }
        },
        watch: {
            value(val) {
                this.$emit('input', val);
            },
            newValue(val) {
                this.$emit('input', val);
            },
        },

        methods: {
            edit() {
                this.editMode = true;
            },
            async add() {
                this.editMode = false;
                this.$emit('input', this.value);

                if(this.isNew){
                    this.$emit('add', this.value);
                } else {
                    this.$emit('edit', this.value);
                }
            },
            async remove(){
                this.editMode = false;
                this.isDeleted = true;

                this.$emit('input', this.value);
                this.$emit('delete', this.value);
            },
            change(){
                this.$emit('change', this.value);
            },
        }
    }
</script>

