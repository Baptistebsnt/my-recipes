import { createRootRoute, Outlet } from "@tanstack/react-router"
import { TanStackRouterDevtools } from "@tanstack/react-router-devtools"

export const Root = createRootRoute({
  component: () => (
    <>
      <hr />
      <Outlet />
      <TanStackRouterDevtools />
    </>
  ),
})

export const Route = Root
