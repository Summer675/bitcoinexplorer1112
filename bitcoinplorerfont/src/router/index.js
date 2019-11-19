import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import scenic from '@/components/scenic'
import Edit from '@/components/Edit'
import List from '@/components/List'
import List2 from '@/components/List2'
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css'

Vue.use(ElementUI);

Vue.use(Router)

export default new Router({
  mode:"history",
  routes: [
    {
      path: '/',
      name: 'HelloWorld',
      component: HelloWorld
    },
    {
      path: '/scenic',
      name: 'scenic',
      component: scenic
    },
    {
      path: '/edit',
      name: 'edit',
      component: Edit
    },
    {
      path: '/list',
      name: 'list',
      component: List
    },
    {
      path: '/list2',
      name: 'list2',
      component: List2
    },
  ]
})
