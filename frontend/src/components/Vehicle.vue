<template>

    <v-card outlined>
        <v-card-title>
            Vehicle
        </v-card-title>

        <v-card-text>
            <String label="VehicleId" v-model="value.vehicleId" :editMode="editMode"/>
            <String label="LicensePlate" v-model="value.licensePlate" :editMode="editMode"/>
            <String label="VehicleType" v-model="value.vehicleType" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions v-if="inList">
            <slot name="actions"></slot>
        </v-card-actions>
    </v-card>
</template>

<script>

    export default {
        name: 'Vehicle',
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
                    'vehicleId': '',
                    'licensePlate': '',
                    'vehicleType': '',
                }
            }
            if(typeof this.value === 'object') {
                if(!('vehicleId' in this.value)) {
                    this.value.vehicleId = '';
                }
            }
            if(typeof this.value === 'object') {
                if(!('licensePlate' in this.value)) {
                    this.value.licensePlate = '';
                }
            }
            if(typeof this.value === 'object') {
                if(!('vehicleType' in this.value)) {
                    this.value.vehicleType = '';
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

