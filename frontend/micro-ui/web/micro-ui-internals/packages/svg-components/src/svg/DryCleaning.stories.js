import React from "react";
import { DryCleaning } from "./DryCleaning";

export default {
  tags: ['autodocs'],
  argTypes: {
    className: {
        options: ['custom-class'],
        control: { type: 'check' },
    }
  },
  title: "DryCleaning",
  component: DryCleaning,
};

export const Default = () => <DryCleaning />;
export const Fill = () => <DryCleaning fill="blue" />;
export const Size = () => <DryCleaning height="50" width="50" />;
export const CustomStyle = () => <DryCleaning style={{ border: "1px solid red" }} />;
export const CustomClassName = () => <DryCleaning className="custom-class" />;
