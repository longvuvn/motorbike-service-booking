import React from 'react';
import { Layout, Menu } from 'antd';
import { UserOutlined, SettingOutlined, DashboardOutlined } from '@ant-design/icons';
import Logo from '../../Logo/logo-primary';
const { Sider } = Layout;


export default function Admin() {
  return (
    <Layout style={{ minHeight: '100vh' }}>
      <Sider collapsible>
        <div style={{ padding: '16px', textAlign: 'center' }}>
          <Logo variant="white" height={40} />
        </div>
        <Menu theme="dark" defaultSelectedKeys={['1']} mode="inline">
          <Menu.Item key="1" icon={<DashboardOutlined />}>
            Dashboard
          </Menu.Item>
          <Menu.Item key="2" icon={<UserOutlined />}>
            Users
          </Menu.Item>
          <Menu.Item key="3" icon={<SettingOutlined />}>
            Settings
          </Menu.Item>
        </Menu>
      </Sider>
    </Layout>
  )
}
