<template>
    <v-card outlined>
        <v-card-title>
            MaintenanceRecord # {{item._links.self.href.split("/")[item._links.self.href.split("/").length - 1]}}
        </v-card-title>

        <v-card-text>
            <div>
                <Number label="RecordId" v-model="item.recordId" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="CarId" v-model="item.carId" :editMode="editMode" @change="change" />
            </div>
            <MaintenanceDetail offline label="MaintenanceDetails" v-model="item.maintenanceDetails" :editMode="false" :key="false" @change="change" />
            <div>
                <Date label="MaintenanceDate" v-model="item.maintenanceDate" :editMode="editMode" @change="change" />
            </div>
            <MaintenanceStatus offline label="Status" v-model="item.status" :editMode="false" :key="false" @change="change" />
            <Car offline label="Car" v-model="item.car" :editMode="false" :key="false" @change="change" />
            <OperationRecordId offline label="OperationRecordId" v-model="item.operationRecordId" :editMode="false" :key="false" @change="change" />
        </v-card-text>

        <v-card-actions>
            <v-btn text color="deep-purple lighten-2" large @click="goList">List</v-btn>
            <v-spacer></v-spacer>
            <v-btn
                    color="primary"
                    text
                    @click="edit"
                    v-if="!editMode"
            >
                Edit
            </v-btn>
            <v-btn
                    color="primary"
                    text
                    @click="save"
                    v-else
            >
                Save
            </v-btn>
            <v-btn
                    color="primary"
                    text
                    @click="remove"
                    v-if="!editMode"
            >
                Delete
            </v-btn>
            <v-btn
                    color="primary"
                    text
                    @click="editMode = false"
                    v-if="editMode"
            >
                Cancel
            </v-btn>
        </v-card-actions>
    </v-card>
</template>


<script>
    const axios = require('axios').default;

    export default {
        name: 'MaintenanceMaintenanceRecordDetail',
        components:{},
        props: {
        },
        data: () => ({
            item: null,
            editMode: false,
        }),
        async created() {
            var me = this;
            var params = this.$route.params;
            var temp = await axios.get(axios.fixUrl('/maintenanceRecords/' + params.id))
            if(temp.data) {
                me.item = temp.data
            }
        },
        methods: {
            goList() {
                var path = window.location.href.slice(window.location.href.indexOf("/#/"), window.location.href.lastIndexOf("/#"));
                path = path.replace("/#/", "/");
                this.$router.push(path);
            },
            edit() {
                this.editMode = true;
            },
            async remove(){
                try {
                    if (!this.offline) {
                        await axios.delete(axios.fixUrl(this.item._links.self.href))
                    }

                    this.editMode = false;

                    this.$emit('input', this.item);
                    this.$emit('delete', this.item);

                } catch(e) {
                    console.log(e)
                }
            },
        },
    };
</script>
