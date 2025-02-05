
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import VehicleOperationOperationRecordManager from "./components/listers/VehicleOperationOperationRecordCards"
import VehicleOperationOperationRecordDetail from "./components/listers/VehicleOperationOperationRecordDetail"

import OperationRecordSummaryView from "./components/OperationRecordSummaryView"
import OperationRecordSummaryViewDetail from "./components/OperationRecordSummaryViewDetail"
import OperationRecordDetailsView from "./components/OperationRecordDetailsView"
import OperationRecordDetailsViewDetail from "./components/OperationRecordDetailsViewDetail"
import DispatchManagementAssignmentRequestManager from "./components/listers/DispatchManagementAssignmentRequestCards"
import DispatchManagementAssignmentRequestDetail from "./components/listers/DispatchManagementAssignmentRequestDetail"

import AssignmentRequestSummaryView from "./components/AssignmentRequestSummaryView"
import AssignmentRequestSummaryViewDetail from "./components/AssignmentRequestSummaryViewDetail"
import AssignmentRequestDetailsView from "./components/AssignmentRequestDetailsView"
import AssignmentRequestDetailsViewDetail from "./components/AssignmentRequestDetailsViewDetail"
import MaintenanceMaintenanceRecordManager from "./components/listers/MaintenanceMaintenanceRecordCards"
import MaintenanceMaintenanceRecordDetail from "./components/listers/MaintenanceMaintenanceRecordDetail"
import MaintenanceVehicleManager from "./components/listers/MaintenanceVehicleCards"
import MaintenanceVehicleDetail from "./components/listers/MaintenanceVehicleDetail"

import MaintenanceHistoryView from "./components/MaintenanceHistoryView"
import MaintenanceHistoryViewDetail from "./components/MaintenanceHistoryViewDetail"
import MaintenanceDetailsView from "./components/MaintenanceDetailsView"
import MaintenanceDetailsViewDetail from "./components/MaintenanceDetailsViewDetail"
import ExpenseManagementExpenseManager from "./components/listers/ExpenseManagementExpenseCards"
import ExpenseManagementExpenseDetail from "./components/listers/ExpenseManagementExpenseDetail"

import ExpenseSummaryView from "./components/ExpenseSummaryView"
import ExpenseSummaryViewDetail from "./components/ExpenseSummaryViewDetail"
import ExpenseDetailsView from "./components/ExpenseDetailsView"
import ExpenseDetailsViewDetail from "./components/ExpenseDetailsViewDetail"
import DashboardOperationSummaryManager from "./components/listers/DashboardOperationSummaryCards"
import DashboardOperationSummaryDetail from "./components/listers/DashboardOperationSummaryDetail"
import DashboardDashboardMetricsManager from "./components/listers/DashboardDashboardMetricsCards"
import DashboardDashboardMetricsDetail from "./components/listers/DashboardDashboardMetricsDetail"

import OperationSummaryReportView from "./components/OperationSummaryReportView"
import OperationSummaryReportViewDetail from "./components/OperationSummaryReportViewDetail"
import OperationDetailsView from "./components/OperationDetailsView"
import OperationDetailsViewDetail from "./components/OperationDetailsViewDetail"

export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [
            {
                path: '/vehicleOperations/operationRecords',
                name: 'VehicleOperationOperationRecordManager',
                component: VehicleOperationOperationRecordManager
            },
            {
                path: '/vehicleOperations/operationRecords/:id',
                name: 'VehicleOperationOperationRecordDetail',
                component: VehicleOperationOperationRecordDetail
            },

            {
                path: '/vehicleOperations/operationRecordSummaries',
                name: 'OperationRecordSummaryView',
                component: OperationRecordSummaryView
            },
            {
                path: '/vehicleOperations/operationRecordSummaries/:id',
                name: 'OperationRecordSummaryViewDetail',
                component: OperationRecordSummaryViewDetail
            },
            {
                path: '/vehicleOperations/operationRecordDetails',
                name: 'OperationRecordDetailsView',
                component: OperationRecordDetailsView
            },
            {
                path: '/vehicleOperations/operationRecordDetails/:id',
                name: 'OperationRecordDetailsViewDetail',
                component: OperationRecordDetailsViewDetail
            },
            {
                path: '/dispatchManagements/assignmentRequests',
                name: 'DispatchManagementAssignmentRequestManager',
                component: DispatchManagementAssignmentRequestManager
            },
            {
                path: '/dispatchManagements/assignmentRequests/:id',
                name: 'DispatchManagementAssignmentRequestDetail',
                component: DispatchManagementAssignmentRequestDetail
            },

            {
                path: '/dispatchManagements/assignmentRequestSummaries',
                name: 'AssignmentRequestSummaryView',
                component: AssignmentRequestSummaryView
            },
            {
                path: '/dispatchManagements/assignmentRequestSummaries/:id',
                name: 'AssignmentRequestSummaryViewDetail',
                component: AssignmentRequestSummaryViewDetail
            },
            {
                path: '/dispatchManagements/assignmentRequestDetails',
                name: 'AssignmentRequestDetailsView',
                component: AssignmentRequestDetailsView
            },
            {
                path: '/dispatchManagements/assignmentRequestDetails/:id',
                name: 'AssignmentRequestDetailsViewDetail',
                component: AssignmentRequestDetailsViewDetail
            },
            {
                path: '/maintenances/maintenanceRecords',
                name: 'MaintenanceMaintenanceRecordManager',
                component: MaintenanceMaintenanceRecordManager
            },
            {
                path: '/maintenances/maintenanceRecords/:id',
                name: 'MaintenanceMaintenanceRecordDetail',
                component: MaintenanceMaintenanceRecordDetail
            },
            {
                path: '/maintenances/vehicles',
                name: 'MaintenanceVehicleManager',
                component: MaintenanceVehicleManager
            },
            {
                path: '/maintenances/vehicles/:id',
                name: 'MaintenanceVehicleDetail',
                component: MaintenanceVehicleDetail
            },

            {
                path: '/maintenances/maintenanceHistories',
                name: 'MaintenanceHistoryView',
                component: MaintenanceHistoryView
            },
            {
                path: '/maintenances/maintenanceHistories/:id',
                name: 'MaintenanceHistoryViewDetail',
                component: MaintenanceHistoryViewDetail
            },
            {
                path: '/maintenances/maintenanceDetails',
                name: 'MaintenanceDetailsView',
                component: MaintenanceDetailsView
            },
            {
                path: '/maintenances/maintenanceDetails/:id',
                name: 'MaintenanceDetailsViewDetail',
                component: MaintenanceDetailsViewDetail
            },
            {
                path: '/expenseManagements/expenses',
                name: 'ExpenseManagementExpenseManager',
                component: ExpenseManagementExpenseManager
            },
            {
                path: '/expenseManagements/expenses/:id',
                name: 'ExpenseManagementExpenseDetail',
                component: ExpenseManagementExpenseDetail
            },

            {
                path: '/expenseManagements/expenseSummaries',
                name: 'ExpenseSummaryView',
                component: ExpenseSummaryView
            },
            {
                path: '/expenseManagements/expenseSummaries/:id',
                name: 'ExpenseSummaryViewDetail',
                component: ExpenseSummaryViewDetail
            },
            {
                path: '/expenseManagements/expenseDetails',
                name: 'ExpenseDetailsView',
                component: ExpenseDetailsView
            },
            {
                path: '/expenseManagements/expenseDetails/:id',
                name: 'ExpenseDetailsViewDetail',
                component: ExpenseDetailsViewDetail
            },
            {
                path: '/dashboards/operationSummaries',
                name: 'DashboardOperationSummaryManager',
                component: DashboardOperationSummaryManager
            },
            {
                path: '/dashboards/operationSummaries/:id',
                name: 'DashboardOperationSummaryDetail',
                component: DashboardOperationSummaryDetail
            },
            {
                path: '/dashboards/dashboardMetrics',
                name: 'DashboardDashboardMetricsManager',
                component: DashboardDashboardMetricsManager
            },
            {
                path: '/dashboards/dashboardMetrics/:id',
                name: 'DashboardDashboardMetricsDetail',
                component: DashboardDashboardMetricsDetail
            },

            {
                path: '/dashboards/operationSummaryReports',
                name: 'OperationSummaryReportView',
                component: OperationSummaryReportView
            },
            {
                path: '/dashboards/operationSummaryReports/:id',
                name: 'OperationSummaryReportViewDetail',
                component: OperationSummaryReportViewDetail
            },
            {
                path: '/dashboards/operationDetails',
                name: 'OperationDetailsView',
                component: OperationDetailsView
            },
            {
                path: '/dashboards/operationDetails/:id',
                name: 'OperationDetailsViewDetail',
                component: OperationDetailsViewDetail
            },


    ]
})
